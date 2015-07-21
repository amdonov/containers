package main
//need to add /remove
//and a implementer for catching errors

import (
	"database/sql"							//used for unifrom database access
	"fmt"									//print statements
	"github.com/go-martini/martini"			//extra frame work build on net/http
	_ "github.com/lib/pq"					//go sql driver 
	"net/http"								//framework
)

func SetupDB() *sql.DB {
	db, err := sql.Open("postgres", "host=192.168.56.40 user=postgres password=1 dbname=postgres sslmode=disable") 		//my only lib/pq usage? login into postgres database
	PanicIf(err)

	return db
}

func PanicIf(err error) {
	if err != nil {
		panic(err)
	}
}

func ShowDB(db *sql.DB, r *http.Request, rw http.ResponseWriter) { //localhost:3000/?search=name
		search := "%" + r.URL.Query().Get("search") + "%"
		rows, err := db.Query(`SELECT fname, LName, cost, city 
                           FROM custauth 
                           WHERE FName ILIKE $1
                           OR LName ILIKE $1
                           OR city ILIKE $1`, search)
		PanicIf(err)
		defer rows.Close()

		var FirstName, LastName, cost, city string
		for rows.Next() {
			err := rows.Scan(&FirstName, &LastName, &cost, &city)
			PanicIf(err)
			fmt.Fprintf(rw, "First Name: %s\nLast Name: %s\nCost: %s\nCity: %s\n\n", FirstName, LastName, cost, city)
		}
	}

func InsertPur(r *http.Request, db *sql.DB){
//	_, err := db.Query("INSERT INTO custauth (custid, fname, lname, city,state, country,email,cost,errorflag) VALUES ($1, $2, $3, $4, $5, $6, $7, $8,$9)",
	_, err := db.Exec("INSERT INTO custauth (custid, fname, lname, city,state, country,email,cost,errorflag) VALUES ($1, $2, $3, $4, $5, $6, $7, $8,$9)",
	r.FormValue("custid"),
		r.FormValue("fname"),
		r.FormValue("lname"),
		r.FormValue("city"),
		r.FormValue("state"),
		r.FormValue("country"),
		r.FormValue("email"),
		r.FormValue("cost"),
		r.FormValue("errorflag"))

	PanicIf(err)
}
	
	

func main() {
	m := martini.Classic()
	m.Map(SetupDB())
	m.Get("/", func() string {
    return "Hello world!"
  })
	m.Get("/show", ShowDB)
	m.Post("/add", InsertPur)
	m.Run()
}
