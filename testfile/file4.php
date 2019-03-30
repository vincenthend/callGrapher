<?php
    class SQLConnector{
        function runQuery($query){
            foreach ($arr as $key => $value) {
                if (!($key % 2)) { // skip even members
                    continue;
                }
                do_something_odd($value);
            }
        }
    }
?>