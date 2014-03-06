(ns riff.core
  (:gen-class)
  (:use compojure.core)
  (:use riff.flickr)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [org.httpkit.client :as http]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as resp]))

(defroutes app-routes
  (GET "/" [] (let [body (:body @(http/get (random-image (fetch-flickr-public-feed))))]
                {:status 200
                 :headers {}
                 :body body})))

(def app
  (handler/site app-routes))

(defn -main [& args]
  (jetty/run-jetty app {:port 8000}))
  
