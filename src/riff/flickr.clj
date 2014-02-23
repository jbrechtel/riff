(ns riff.flickr
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]
            [clojure.data.zip.xml :as zip-xml]))

(defn fetch-flickr-public-feed []
  (xml/parse "https://api.flickr.com/services/feeds/photos_public.gne"))

(defn feed-images [fz]
  (zip-xml/xml-> fz :entry :link (zip-xml/attr= :type "image/jpeg") (zip-xml/attr :href)))

(defn random-image [feed]
  (let [images (vec (feed-images (zip/xml-zip feed)))]
    (images (rand-int (count images)))))
