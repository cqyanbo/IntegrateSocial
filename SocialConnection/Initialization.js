
exports.initial = function(express, app){
	// set logger
	var logger = require('./routes/log.js').SetUpLogger();
	
	//set up handlebars view engine
	var handlebars = require('express3-handlebars')
	.create({ 
		defaultLayout:'main',
		helpers: {
			section: function(name, options){
				if(!this._sections){
					this._sections = {};
				}
				this._section[name] =   options.fn(this);
				return null;
			}
		}
	});
	
	Handlebars.registerPartial('login', './login/login');

	// routings
	var routings = require('./routes/routers.js');
	
	// set up engine
	app.engine('handlebars', handlebars.engine);
	app.use(express.static(__dirname + '/public'));

	//  tester
	app.use(function(req, res, next){
		res.locals.showTests = app.get('env') !== 'production' &&
		req.query.test === '1';
		next();
	});

	// set up view engine
	app.set('view engine', 'handlebars');
	
	// set up routes
	routings.setRoutURLS(app);
	
	// set up port
	app.set('port', process.env.PORT || 3000);


	// launch
	app.listen(app.get('port'), function(){
		console.log( 'Express started on http://localhost:' +
		app.get('port') + '; press Ctrl-C to terminate.' );
	});
};
