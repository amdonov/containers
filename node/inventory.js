var mongous = require('mongous').Mongous;
var objectID = require("mongous/bson/objectid").ObjectID;

var express = require('express');
var app = express();
var bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

var port = 1337; //set listening port to 1337

var router = express.Router();

mongous().open("db", 27017);

//DONE: basic test for connectivity.
router.get('/', function(req, res) {
	res.json({message: 'Inventory Service Home' });
	
});
	
//DONE, basic GET, GET .../inventory/category/identifier (ie title/Titanic or mediatype/novel), returns product.
router.route('/:category/:identifier')
    .get(function(req, res) {
		var query = {};
		query[req.params.category] = req.params.identifier;
		
		mongous('test.products').find(query, function(docs) {
			console.log(docs);
			res.json(docs);
		});
    });

//GET by ID.
router.route('/:id')
    .get(function(req, res) {
		var entry = {};
		entry['_id'] = objectID(req.params.id);
		mongous('test.products').find(entry, function(docs) {
			res.json(docs);
		});
    });
	

//PUT method for :id, alter contents by ID. body.field : body.identifier added to document.
router.route('/:id')
	.put(function(req, res) {
		var query = {}
		query['_id'] = objectID(req.params.id);
		
		var entry = {};
		entry[req.body.field] = req.body.identifier;
		
		console.log(req.body.field);
		console.log(req.body.identifier);
		mongous('test.products').update(query, {$set : entry}); //$set denotes that should only update or add, not replace document.
		res.json(mongous("test.products").find(query)); //verification by sending the found document.
			/*
			
			item.mediatype = req.body.mediatype;
			item.markModified('item.mediatype');
			item.save();
			res.json(item);
			*/
        });
		
		
//PUT may need more testing.
//Input title and mediatype in the body. This should act as a psuedo primary key. In the body of the http request,
//have a field for 'field' and for 'identifier.' This either updates a field value if existing, or adds the
//field value else.
router.route('/')
	.put(function(req, res) {
		
		var query = {};
		query['mediatype'] = req.body.mediatype;
		query['title'] = req.body.title;
		
		var entry = {};
		entry[req.body.field] = req.body.identifier;
		
		console.log(req.body.field);
		console.log(req.body.identifier);
		mongous('test.products').update(query, {$set : entry}); //$set denotes that should only update or add, not replace document.
		res.json(mongous("test.products").find(query)); //verification by sending the found document.
        });
		
//PUT method changing the quantity of item in stock. Can take negative or positive number. If result is < 0, will not execute. 
router.route('/stocking/:id')
	.put(function(req, res) {
		
		var query = {};
		query['_id'] = objectID(req.params.id);
		
		var entry = {};
		entry['stock'] = parseInt(req.body.change);
				
		mongous('test.products').find(query, function(docs) {
			var result = parseInt(req.body.change) + parseInt(docs.documents[0].stock);
			if (result > 0) {
				mongous('test.products').update(query, {$inc : entry}); //$set denotes that should only update or add, not replace document.
				res.json("Successfully updated."); 
			}
			else {
				res.json("Update failed.");
			}
		});
		
        });
		
//POST adds a new item to inventory. input title and mediatype in the body. Will duplicate item.
router.route('/')
    .post(function(req, res) {
		var entry = {};
		entry['mediatype'] = req.body.mediatype;
		entry['title'] = req.body.title;
		entry['stock'] = 0;
		mongous("test.products").insert(entry);
		res.json({message : 'Product added to system.'});
	});
	
//DELETE removes 1 object where object has id = :id
router.route('/:id')
	.delete(function(req, res) {
		var entry = {};
		entry['_id'] = objectID(req.params.id);

		//entry['mediatype'] = req.params.mediatype;
		//entry['title'] = req.params.title;

		mongous("test.products").remove(entry);
		
		res.json({message : 'Entry removed'});
	});

app.use('/inventory', router);

app.listen(1337);
console.log('Starting server...');




