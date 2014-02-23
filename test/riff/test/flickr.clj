(ns riff.test.flickr
  (:use clojure.test
        riff.flickr)
  (:require [clojure.xml :as xml]))

(def test-feed (xml/parse "test/test-feed.xml"))

(deftest test-app
  (testing "returns a url"
    (let [image (random-image test-feed)]
      (is (.startsWith image "https://")))))
