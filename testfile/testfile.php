<?php
    class Foo{
        function getUser($username){
            $connection = mysqli_connect("127.0.0.1","root","password","database_test");
            if($connection){
                mysqli_real_escape_string($username);
            } elseif($conn){
                meow();
            } else {
                meong();
            }
        }
    }
?>