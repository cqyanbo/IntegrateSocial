// load log system
var winston = require('winston');

winston.log('info', 'Start Application!');

//set up logger
exports.SetUpLogger =  function(){
	var logger = new (winston.Logger)({
	    transports: [
	      new (winston.transports.Console)(),
	      new (winston.transports.File)({ filename: './log.log' })
	    ]
	  });
	winston.info('Set up log file');
	return logger;
};