(ns micro-business.web.landingpage
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(enable-console-print!)

(defui TopNavBar
  Object
  (render [this]
          (dom/nav
           #js {:className "navbar navbar-default navbar-custom navbar-fixed-top"}
           (dom/div
            #js {:className "container-fluid"}
            (dom/div
             #js {:className "navbar-header page-scroll"}
             (dom/button
              #js {:className "navbar-toggle" :data-toggle "collapse" :data-target "#bsbsbs"}
              (dom/span #js{:className "sr-only"} "Toggle navigation")
              "Menu"
              (dom/i #js{:className "fa fa-bars"}))

             (dom/a
              #js {:className "navbar-brand" :href "index.html"}
              "Micro Business")))

           (dom/div #js {:className "collapse navbar-collapse" :id "bsbsbs"}

                    (dom/ul #js {:className "nva navbar-nav navbar-right"}

                            (dom/li
                             nil
                             (dom/a #js {:href "index.html"} "Home"))

                            (dom/li
                             nil
                             (dom/a #js {:href "index.html"} "About"))

                            (dom/li
                             nil
                             (dom/a #js {:href "index.html"} "Sample Post"))

                            (dom/li
                             nil
                             (dom/a #js {:href "index.html"} "Login")))))))

(def topNavBar (om/factory TopNavBar))

(defui SmartSearch
  Object
  (render [this]
          ;; (dom/div
          ;;  #js {:className "row"}
           (dom/div
            #js {:className "col-sm-8 col-md-7 col-md-offset-2"}
            ;; #js {:className "col-lg-4 col-lg-offset-4"}
            (dom/div
             #js {:className "input-group"}
             (dom/div
              nil
              (apply dom/span #js {:className "input-group-btn"}
                     [(dom/input #js {:className "form-control" :placeholder "Search" :type "text"})
                      (dom/button #js {:className "btn btn-default"} "Search")]))))))
;; )

(def smartSearch (om/factory SmartSearch))

(defui LandingPage
  Object
  (render [this]
          (apply dom/div nil
                 [;; (topNavBar this)

                  (smartSearch this)])))

(def landingPage (om/factory LandingPage))

(defn ^:export renderLandingPage [elementName]
  (js/ReactDOM.render (landingPage) (gdom/getElement elementName)))

(renderLandingPage  "landingPageArea")
