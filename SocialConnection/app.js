// load log system
var winston = require('winston');

winston.log('info', 'Start Application!');

//set up logger
var logger = new (winston.Logger)({
    transports: [
      new (winston.transports.Console)(),
      new (winston.transports.File)({ filename: './log.log' })
    ]
  });
winston.info('Set up log file');

//load express
var express = require('express');
winston.log('info', 'Express loaded.');


var fortune = require('./lib/fortune/fortune.js');
winston.log('info', 'fortune.js loaded.');

var app = express();

//set up handlebars view engine
var handlebars = require('express3-handlebars')
.create({ defaultLayout:'main' });
app.engine('handlebars', handlebars.engine);
app.use(express.static(__dirname + '/public'));

app.use(function(req, res, next){
	res.locals.showTests = app.get('env') !== 'production' &&
	req.query.test === '1';
	next();
});

app.set('view engine', 'handlebars');


app.get('/', function(req, res) {
	res.render('login/home');
});
	
	app.get('/about', function(req, res) {
		res.render('about', { 
			fortune: fortune.getFortune(),
			pageTestScript: '/qa/tests-about.js'
		});
	});
	
	app.get('/tours/hood-river', function(req, res){
		res.render('tours/hood-river');
	});
		
	app.get('/tours/request-group-rate', function(req, res){
		res.render('tours/request-group-rate');
	});
	
	// 404 catch-all handler (middleware)
	app.use(function(req, res, next){
	res.status(404);
	res.render('404');
	});
	
	// 500 error handler (middleware)
	app.use(function(err, req, res, next){
	console.error(err.stack);
	res.status(500);
	res.render('500');
	});
	
	app.set('port', process.env.PORT || 3000);


app.listen(app.get('port'), function(){
console.log( 'Express started on http://localhost:' +
app.get('port') + '; press Ctrl-C to terminate.' );
});