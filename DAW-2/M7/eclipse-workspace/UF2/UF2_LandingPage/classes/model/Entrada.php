<?php

class Entrada {
    // Si son objetos de negocio con atributos públicos, no necesitan de constructor.
    
    public $esdeveniment_id;
    public $data_id;
    public $loc_id;
    public $zona_id;
    public $pagament_id;
    public $id;
    public $fila;
    public $butaca;
    public $dni;
    public $esdeveniment;
    public $data;
    public $loc;
    public $zona;
    public $pagament;

    public function __construct($esdeveniment_id, $data_id, $loc_id, $zona_id, $pagament_id, $id, $fila, $butaca, $dni, $esdeveniment = null, $data = null, $loc = null, $zona = null, $pagament = null){
        $this->esdeveniment_id = $esdeveniment_id;
        $this->data_id = $data_id;
        $this->loc_id = $loc_id;
        $this->zona_id = $zona_id;
        $this->pagament_id = $pagament_id;
        $this->id = $id;
        $this->fila = $fila;
        $this->butaca = $butaca;
        $this->dni = $dni;
        $this->esdeveniment = $esdeveniment;
        $this->data = $data;
        $this->loc = $loc;
        $this->zona = $zona;
        $this->pagament = $pagament;
    }
}

