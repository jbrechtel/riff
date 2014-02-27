(defproject riff "0.0.1"
  :description "A random image from Flickr"
  :url "http://riff.nevercertain.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [http-kit "2.1.16"]
                 [org.clojure/data.zip "0.1.1"]
                 [ring "1.2.0"]
                 [compojure "1.1.6"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler riff.core/app-routes}
  :uberjar-name "riff-web.jar"
  :main riff.core)
