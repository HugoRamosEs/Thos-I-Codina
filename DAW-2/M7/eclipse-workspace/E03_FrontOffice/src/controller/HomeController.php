<?php
namespace controller;

use view\HomeView;

class HomeController extends Controller {
    public function __construct() {
        parent::__construct();
    }
    
    public function show() {
        HomeView::show();
    }
}