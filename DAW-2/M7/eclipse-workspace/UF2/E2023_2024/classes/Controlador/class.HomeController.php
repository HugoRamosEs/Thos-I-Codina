<?php
class HomeController extends Controller {
    public function __construct(){}
    
    public function show(){
        EventsView::show(EventModel::read());
    }
}

