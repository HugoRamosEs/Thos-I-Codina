<?php
//     error_reporting(E_ALL);
//     ini_set('display_errors', 1);
    ini_set('memory_limit', '512M');
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Methods: GET, POST, OPTIONS');
    header('Access-Control-Allow-Headers: Content-Type');

    $q = json_decode(file_get_contents('php://input'), true);
    
    if ($q) {
        $data = [];
        $placeholders = implode(',', array_fill(0, count($q), '?'));
        $sql = "SELECT * FROM TBL_NAME WHERE Codi_Districte IN ($placeholders) ORDER BY Codi_Districte DESC";
        $data = $q;
    } else {
        $sql = "SELECT * FROM TBL_NAME ORDER BY Codi_Districte DESC";
    }
    
    try {
        $dbh = new PDO('mysql:host=localhost;dbname=CSV_DB;charset=utf8', 'usr_generic', '2024@Thos');
        $sth = $dbh->prepare($sql);
        $sth->execute($data);
        $result = $sth->fetchAll(PDO::FETCH_ASSOC);
    } catch (PDOException $e) {
        print "Error!: " . $e->getMessage() . "<br/>";
        die();
    }
    
    echo json_encode($result);
    
    /*
     try {
         $sql= "SELECT * FROM TBL_NAME";
         $dbh = new PDO('mysql:host=localhost;dbname=CSV_DB;charset=utf8', 'usr_generic', '2024@Thos');
         $sth = $dbh->prepare($sql);
         $sth->execute();
         $result = $sth->fetchAll(PDO::FETCH_ASSOC);
     } catch (PDOException $e) {
         print "Error!: " . $e->getMessage() . "<br/>";
         die();
     }
     
     echo json_encode($result);
     */
    
    