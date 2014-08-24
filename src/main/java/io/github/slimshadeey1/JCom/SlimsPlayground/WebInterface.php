<?php
/**
 * Created by IntelliJ IDEA.
 * User: Ben Byers
 * Date: 8/23/2014
 * Time: 11:31 PM
 */

function send($data,$address,$port){
    $socket = socket_create(AF_INET,SOCK_STREAM,SOL_TCP);
    socket_connect($socket,$address,$port);
    $length = strlen($data);
    while(true){
        socket_write($socket, $data, $length);
    }
}
function process($data){

}
