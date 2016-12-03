(ns micro-business.web.landingpage.rootview
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.uicomponents.uikit.navbar.navigationbar :as navigationbar]))

(defui LandingPageRootView
  static om/Ident
  (ident [this {:keys [id]}]
         [:landing-page/by-id id])

  static om/IQuery
  (query [this]
         (let [navBarSubquery (om/get-query navigationbar/NavBar)]
           `[{:navigationBars ~navBarSubquery}]))

  Object
  (render [this]
          (let [{:keys [navigationBars]} (om/props this)
                rootViewStyle #js {:className "uk-container uk-container-center uk-margin-top"}]
            (dom/div
             rootViewStyle
             (map navigationbar/navBar navigationBars)))))

(def landingPageRootView (om/factory LandingPageRootView))
