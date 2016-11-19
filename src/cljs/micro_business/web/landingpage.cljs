(ns micro-business.web.landingpage
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(enable-console-print!)

(defui LandingPage
  Object
  (render [this]
          (dom/div nil "Micro Business")))

(def landingPage (om/factory LandingPage))

(defn ^:export renderLandingPage [elementName]
  (js/ReactDOM.render (landingPage) (gdom/getElement elementName)))

(renderLandingPage  "landingPageArea")
