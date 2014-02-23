(ns riff.flickr
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]
            [clojure.data.zip.xml :as zip-xml]))

(defn feed []
  (xml/parse "https://api.flickr.com/services/feeds/photos_public.gne"))

(defn feed-zip [f]
  (zip/xml-zip f))

(defn feed-images [fz]
  (zip-xml/xml-> fz :entry :link (zip-xml/attr= :type "image/jpeg") (zip-xml/attr :href)))

(defn random-image []
  (let [images (vec (feed-images (feed-zip (feed))))]
    (images (rand-int (count images)))))
