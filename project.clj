(defproject micro-business-microbusinessweb "0.1.0-SNAPSHOT"
  :description "Micro Businesses Web"
  :url "https://github.com/micro-business/MicroBusinessWeb"
  :license {:name "GPL-3.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293"]
                 [org.omcljs/om "1.0.0-alpha47"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-cljfmt "0.5.6"]]

  :profiles {:dev {:source-paths ["src/cljs"]}}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/dev/js/main.js"
                                   :output-dir "resources/public/dev/js"
                                   :optimizations :none
                                   :pretty-print true
                                   :source-map true}}
                       {:id "test"
                        :source-paths ["src/cljs" "test/cljs"]
                        :compiler {:output-to "resources/public/test/js/main.js"
                                   :output-dir "resources/public/test/js"
                                   :optimizations :whitespace
                                   :pretty-print true
                                   :source-map "resources/public/test/js/main.js.map"}}
                       {:id "prod"
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/prod/js/main.js"
                                   :output-dir "resources/public/prod/js"
                                   :optimizations :advanced
                                   :pretty-print false}}]})
