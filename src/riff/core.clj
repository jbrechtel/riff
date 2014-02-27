(ns riff.core
  (:gen-class)
  (:use compojure.core)
  (:use riff.flickr)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as resp]))

(defroutes app-routes
  (GET "/" [] (resp/redirect (random-image (fetch-flickr-public-feed)))))

(def app
  (handler/site app-routes))

(defn -main [& args]
  (jetty/run-jetty app {:port 8000}))
  
