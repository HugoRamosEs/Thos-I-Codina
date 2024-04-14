<?php
class EventController extends Controller {
    private Event $esdeveniment;
    
    public function __construct(Event $param) {
        parent::__construct();
        $this->esdeveniment = $param;
    }
    
    public function get($param) {
        
    }
    
    public function post($param) {
        
    }
    
    public function __getter(){
        return $this->esdeveniment;
    }
    
    public function __setter($param){
        $this->esdeveniment = $param;
    }
}

?>