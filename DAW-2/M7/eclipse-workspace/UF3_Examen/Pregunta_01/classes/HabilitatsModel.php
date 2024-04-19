<?php
namespace curriculum;

class HabilitatsModel extends Model {
    
    public function __construct() {
        parent::__constrcut();
    }
    
    public function getByUser(Usuari $oUsuari) {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_habilitats WHERE usuari_id = ?;");
        $stmt->bind_param("i", $oUsuari->getId());
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Habilitat();
                $oItem->setCategoria($item['categoria']);
                $oItem->setValoracio($item['valoracio']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;
    }
    
    public function getAll() {
        $aItems = array();
        
        $stmt = $this->link->prepare("SELECT * FROM tbl_habilitats WHERE usuari_id = ?;");
        $stmt->execute();
        $res = $stmt->get_result();
        if ($res->num_rows > 0) {
            while ($item = $res->fetch_assoc()) {
                $oItem = new Habilitat();
                $oItem->setCategoria($item['categoria']);
                $oItem->setValoracio($item['valoracio']);
                
                $aItems[] = $oItem;
            }
        }
        return $aItems;
    }
}

