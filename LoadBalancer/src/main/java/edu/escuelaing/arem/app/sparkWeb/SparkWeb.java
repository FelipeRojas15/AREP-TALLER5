/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.app.sparkWeb;
import edu.escuelaing.arem.app.*;
import java.io.IOException;
import static spark.Spark.*;
import spark.Request;
import spark.Response;
/**
 *
 * @author rojas
 */


public class SparkWeb {
    public static void main(String[] args){

        staticFileLocation("/static");
        HTTPClient conexion = new HTTPClient();
        port(getPort());
        post("/result",(request,response)-> {
            conexion.roundRobin();
            conexion.postMessage(request.body(), "/result");

            return "Dato insertado";

        });
        get("/result", (req, res) -> {
            conexion.roundRobin();
            return conexion.getMessages("/result");

        });
        
    }

    public static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; 
    }
}
