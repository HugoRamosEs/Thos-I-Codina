<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);
    
    require_once "bootstrap.php";

    use Frases\Entity\Autor;
    use Frases\Entity\Tema;
    use Frases\Entity\Frase;
    use Doctrine\ORM\Query\ResultSetMappingBuilder;
    
//     SELECCIONAR LLISTA TEMES AMB EL NÚMERO DE FRASES
    try {
        // DQL
        $qb = $entityManager->createQueryBuilder();
        $qb ->select("t.nombre", "COUNT(f.id) as num")
            ->from("Frases\Entity\Tema", "t")
            ->leftJoin("t.frases", "f")
            ->groupBy("t.id");
        
        $query = $qb->getQuery();
        $temes = $query->getResult();
        
        // SQL PUR
        $rsmb = new ResultSetMappingBuilder($entityManager);
        $rsmb->addRootEntityFromClassMetadata('Frases\Entity\Tema', 't');

        $sql = <<<SQL
        SELECT t.id, t.nombre, COUNT(ft.frase_id) as num
        FROM `tbl_temes` t
        INNER JOIN `tbl_frases_temes` ft ON t.id = ft.tema_id
        INNER JOIN `tbl_frases` f ON f.id = ft.frase_id
        GROUP BY t.id, t.nombre;
        SQL;
                
        $query2 = $entityManager->createNativeQuery($sql, $rsmb);
        $temes2 = $query2->getResult();
        
        // SQL NADIU (NATIVE QUERY)
        $sql = "SELECT * from tbl_temes t left join tbl_frases_temes ft on t.id = fr.tema_id";
        $oRSMB = new ResultSetMappingBuilder($entityManager);
        $oRSMB->addRootEntityFromClassMetadata('Frases\Entity\Tema', 't');
        $oRSMB->addJoinedEntityFromClassMetadata('Frases\Entity\Frase', 'f', 't', 'frases', array('id' => 'frase_id'));
        $qNativa = $entityManager->createNativeQuery($sql, $oRSMB);
        $temes3 = $qNativa->getResult();
                
        echo "<html>
        <head>
            <title>Frases Célebres</title>
            <link rel='stylesheet' type='text/css' href='styles.css'>
        </head>
        <body>
            <div id='contenedor'>
                <h1>Frases Célebres</h1>
                <nav>
                    <ul>
                        <li><a href='#dql'>DQL</a></li>
                        <li><a href='#sql'>SQL Nadiu</a></li>
                    </ul>
                </nav>
                <h2 id='dql'>DQL</h2>
                <table>
                <thead>
                    <tr>
                        <th>Tema</th>
                        <th>Num. Frases</th>
                    </tr></thead>";
        foreach ($temes as $tema) {
            echo "<tr>";
            echo "<td>" . $tema["nombre"] . "</td>";
            echo "<td>" . $tema["num"] . "</td>";
            echo "</tr>";
        }
        echo "</div></table>
                <h2 id='sql'>SQL Nadiu</h2>
                <table>
                <thead>
                    <tr>
                        <th>Tema</th>
                        <th>Num. Frases</th>
                    </tr></thead>";
        foreach ($temes2 as $tema) {
            echo "<tr>";
            echo "<td>" . $tema->getNombre() . "</td>";
            echo "<td>" . $tema->getFrases()->count() . "</td>";
            echo "</tr>";
        }
        
        echo "</tbody></table></body></html>";
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }
