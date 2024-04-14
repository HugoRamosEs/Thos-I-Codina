<?php

class Event {
    private $_name;
    private $_from;
    private $_to;
    private $_tag;
    
    public function __construct($name, $from, $to, $tag) {
        $this->_name = $name;
        $this->_from = $from;
        $this->_to = $to;
        $this->_tag = $tag;
    }
}

