(ns app.core
    (:require [org.httpkit.server :as server]
      [compojure.core :refer :all]
      [compojure.route :as route]
      [ring.middleware.defaults :refer :all]
      [clojure.string :as str]
      [clojure.data.json :as json]
      [scrambler.core :as scrambler])
    (:gen-class))

(defn get-parameter [request parameter_name]
      (get (:params request) parameter_name))

(defn scramble [request]
      {:status  200
       :headers {"Content-Type" "text/json"}
       :body    (str (json/write-str (core/return-scrambled-string (get-parameter request :haystack) (get-parameter request :needle))))})

(defroutes app-routes
           (GET "/scramble" [] scramble)
           (route/not-found "Error, page not found!"))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; Run the server with Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    ; Run the server without ring defaults
    ;(server/run-server #'app-routes {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
