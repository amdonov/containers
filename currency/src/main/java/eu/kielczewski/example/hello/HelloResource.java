package eu.kielczewski.example.hello;

import eu.kielczewski.example.config.MessagesConfiguration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.text.DecimalFormat;


@Path(value = "/converter")
public class HelloResource {

    private final MessagesConfiguration conf;

    public HelloResource(MessagesConfiguration conf) {
        this.conf = conf;
    }

    @GET
    public String sayHello() {
        return conf.getHello();
    }

    @GET
    @Path("readme")
    public String readMe(){
        return "Supports: Dollars, Yuan, Euros";
    }

    @GET
    @Path("DY/{number}")
    public String dollarToYuan(@PathParam("number") final String number) {
        try{
            Double startVal = Double.parseDouble(number);
            Double convertedVal = startVal*6.20;
            DecimalFormat df = new DecimalFormat("#.##");


            return df.format(startVal) + " Dollars = " + df.format(convertedVal) + " Yuan";

        }catch(NumberFormatException e) {
            return "\""+ number + "\" is not a number!";
        }
    }

    @GET
    @Path("YD/{number}")
    public String yuanToDollar(@PathParam("number") final String number) {
        try{
            Double startVal = Double.parseDouble(number);
            Double convertedVal = startVal*0.16;
            DecimalFormat df = new DecimalFormat("#.##");


            return df.format(startVal) + " Yuan = " + df.format(convertedVal) + " Dollars";

        }catch(NumberFormatException e) {
            return "\""+ number + "\" is not a number!";
        }
    }

    @GET
    @Path("ED/{number}")
    public String euroToDollar(@PathParam("number") final String number) {
        try{
            Double startVal = Double.parseDouble(number);
            Double convertedVal = startVal*1.13;
            DecimalFormat df = new DecimalFormat("#.##");


            return df.format(startVal) + " Euros = " + df.format(convertedVal) + " Dollars";

        }catch(NumberFormatException e) {
            return "\""+ number + "\" is not a number!";
        }
    }

    @GET
    @Path("DE/{number}")
    public String dollarToEuro(@PathParam("number") final String number) {
        try{
            Double startVal = Double.parseDouble(number);
            Double convertedVal = startVal*0.89;
            DecimalFormat df = new DecimalFormat("#.##");


            return df.format(startVal) + " Dollars = " + df.format(convertedVal) + " Euros";

        }catch(NumberFormatException e) {
            return "\""+ number + "\" is not a number!";
        }
    }

    @GET
    @Path("YE/{number}")
    public String yuanToEuro(@PathParam("number") final String number) {
        try{
            Double startVal = Double.parseDouble(number);
            Double convertedVal = startVal*0.14;
            DecimalFormat df = new DecimalFormat("#.##");


            return df.format(startVal) + " Yuan = " + df.format(convertedVal) + " Euros";

        }catch(NumberFormatException e) {
            return "\""+ number + "\" is not a number!";
        }
    }

    @GET
    @Path("EY/{number}")
    public String euroToYuan(@PathParam("number") final String number) {
        try{
            Double startVal = Double.parseDouble(number);
            Double convertedVal = startVal*7.01;
            DecimalFormat df = new DecimalFormat("#.##");


            return df.format(startVal) + " Euros = " + df.format(convertedVal) + " Yuan";

        }catch(NumberFormatException e) {
            return "\""+ number + "\" is not a number!";
        }
    }
}

