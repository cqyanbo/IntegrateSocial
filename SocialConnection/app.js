var express = require('express');
var app = express();
var setup = require('./Initialization.js');

setup.initial(express, app);
