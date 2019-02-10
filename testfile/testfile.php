<?php
    class Foo{
        function getUser($username){
            $connection = mysqli_connect("127.0.0.1","root","password","database_test");
            if($connection){
                mysqli_real_escape_string($username);
                $sql = "SELECT * FROM users WHERE username='".$username."'";
                $result = mysqli_query($sql);
                if(mysqli_num_rows($result) > 0){
                    while($row = mysqli_fetch_assoc($result)){
                        echo "username :".$row['username']." phone:".$row['phone']."<br>";
                    }
                }
            }
        }
    }
?>