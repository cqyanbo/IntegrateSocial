/**
 * New node file
 */

exports.setRoutURLS = function(app){
	
	app.get('/', function(req, res) {
		res.render('login/home', {content: '/login/login.handlebars'});
	});
	
	app.get('/about', function(req, res) {
		res.render('about', { 
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
}