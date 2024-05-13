<?php
namespace controller;

use model\Event;

class EventController extends Controller {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function get($data) {
        if (isset($data["id"]) && trim($data["id"]) !== "") {
            $data["id"] = $this->sanitize($data["id"]);
            $event = $this->entityManager->getRepository(Event::class)->findOneBy(["id" => $data["id"]]);
            if ($event === null) {
                http_response_code(404);
                return ["error" => "Event not found"];
            } else {
                return $this->parseResult($event);
            }
        }
        
        $events = $this->entityManager->getRepository(Event::class)->findAll();
        return $this->parseResult($events);
    }
}
