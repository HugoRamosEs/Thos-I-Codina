<?php
function generaDivsAmbProductes($productes = null) {
    $prods = [];
    if ($productes == null) {
        $result = "<p>Els productes no existeixen ....</p>";
    } else {
        foreach ($productes as $ref => $producte) {
            $result = "<div class=\"item col-lg-4\"><div class=\"thumbnail\"><div class=\"caption\">
                    <h4 class=\"list-group-item-heading\">{$producte["name"]}</h4>
                    <p class=\"list-group-item-text\">{$producte["description"]}</p>
                    <div class=\"row\"><div class=\"col-md-6\">
                      <p class=\"lead\">{$producte["price"]} EUR</p>
                    </div>
                    <div class=\"col-md-6\">
                      <a class=\"btn btn-success\" href=\"accioCarro.php?action=addToCart&id={$producte["id"]}\">Afegir al Carro</a>
                    </div></div></div></div></div>";
            $prods[] = $result;
        }
    }
    return implode(' ', $prods);
}


function carregaDeDades(){
    // get the shopping cart array from the session
    $cart_contents = !empty($_SESSION['cart_contents'])?$_SESSION['cart_contents']:NULL;
    if ($cart_contents === NULL){
        // set some base values
        $cart_contents = array('cart_total' => 0, 'total_items' => 0);
    }
    return $cart_contents;
}

function insert($cart_contents, $item = array()){
    if(!is_array($item) OR count($item) === 0){
        return FALSE;
    }else{
        if(!isset($item['id'], $item['name'], $item['price'], $item['qty'])){
            return FALSE;
        }else{
            /*
             * Insert Item
             */
            // prep the quantity
            $item['qty'] = (float) $item['qty'];
            if($item['qty'] == 0){
                return FALSE;
            }
            // prep the price
            $item['price'] = (float) $item['price'];
            // create a unique identifier for the item being inserted into the cart
            $rowid = md5($item['id']);
            // get quantity if it's already there and add it on
            $old_qty = isset($cart_contents[$rowid]['qty']) ? (int) $cart_contents[$rowid]['qty'] : 0;
            // re-create the entry with unique identifier and updated quantity
            $item['rowid'] = $rowid;
            $item['qty'] += $old_qty;
            $cart_contents[$rowid] = $item;
            
            // save Cart Item
            if(save_cart($cart_contents)){
                return isset($rowid) ? $rowid : TRUE;
            }else{
                return FALSE;
            }
        }
    }
}

function update($cart_contents, $item = array()){
    if (!is_array($item) OR count($item) === 0){
        return FALSE;
    }else{
        if (!isset($item['rowid'], $cart_contents[$item['rowid']])){
            return FALSE;
        }else{
            // prep the quantity
            if(isset($item['qty'])){
                $item['qty'] = (float) $item['qty'];
                // remove the item from the cart, if quantity is zero
                if ($item['qty'] == 0){
                    unset($cart_contents[$item['rowid']]);
                    return TRUE;
                }
            }
            
            // find updatable keys
            $keys = array_intersect(array_keys($cart_contents[$item['rowid']]), array_keys($item));
            // prep the price
            if(isset($item['price'])){
                $item['price'] = (float) $item['price'];
            }
            // product id & name shouldn't be changed
            foreach(array_diff($keys, array('id', 'name')) as $key){
                $cart_contents[$item['rowid']][$key] = $item[$key];
            }
            // save cart data
            $this->save_cart($cart_contents);
            return TRUE;
        }
    }
}

function save_cart($cart_contents){
    $cart_contents['total_items'] = $cart_contents['cart_total'] = 0;
    foreach ($cart_contents as $key => $val){
        // make sure the array contains the proper indexes
        if(!is_array($val) OR !isset($val['price'], $val['qty'])){
            continue;
        }
        
        $cart_contents['cart_total'] += ($val['price'] * $val['qty']);
        $cart_contents['total_items'] += $val['qty'];
        $cart_contents[$key]['subtotal'] = ($cart_contents[$key]['price'] * $cart_contents[$key]['qty']);
    }
    
    // if cart empty, delete it from the session
    if(count($cart_contents) <= 2){
        unset($_SESSION['cart_contents']);
        return FALSE;
    }else{
        $_SESSION['cart_contents'] = $cart_contents;
        return TRUE;
    }
}

function remove($cart_contents, $row_id){
    // unset & save
    unset($cart_contents[$row_id]);
    save_cart($cart_contents);
    return TRUE;
}

function generaTBody($cart) {
    $prodsCarro = [];
    if ($cart['total_items'] > 0) {
        $cartReverse = array_reverse($cart);
        foreach ($cartReverse as $key => $producte) {
            if ($key === 'cart_total' || $key === 'total_items') {
                continue;
            }
            $prodsCarro[] = "<tr><td>{$producte["name"]}</td>
            <td>{$producte["price"]}</td>
            <td><input type=\"number\" class=\"form-control text-center\" value=\"1\" onchange=\"updateCartItem(this, '{$key}')\"></td>
            <td>{$producte["price"]}</td>
            <td><a href=\"accioCarro.php?action=removeCartItem&id={$key}\" class=\"btn btn-danger\" onclick=\"return confirm('Confirma eliminar?')\"><i class=\"glyphicon glyphicon-trash\"></i></a>
            </td></tr>";
        }
    } else {
        $prodsCarro[] = '<tr><td colspan="5"><p>El teu carro està buit.....</p></td>';
    }
    return implode(' ', $prodsCarro);
}

function generaTBodyManteniment($productes) {
    foreach($productes as $codi => $item){
        $result .= "<tr><td>{$item["id"]}</td>
        <td>{$item["name"]}</td>
        <td>{$item["description"]}</td>
        <td>{$item["price"]} EUR</td>
        <td><a href=\"mantenimentProductes.php?action=removeItem&id=$codi\" class=\"btn btn-danger\" onclick=\"return confirm('Confirma eliminar?')\"><i class=\"glyphicon glyphicon-trash\"></i></a>
        </td></tr>";
    }
 
    return $result;
}

function generaTFooter($cart) {
    if($cart['total_items'] > 0) { 
        $result = "<td class=\"text-center\"><strong>Total {$cart['cart_total']} EUR</strong></td>";
    }
    return $result;
}

