(ns riff.core
  (:use compojure.core)
  (:use riff.flickr)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]))

(defroutes app
  (GET "/" [] (resp/redirect (random-image (fetch-flickr-public-feed)))))
