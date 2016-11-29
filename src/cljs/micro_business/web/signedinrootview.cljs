(ns micro-business.web.signedinrootview
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.uicomponents.uikit.navigationbar :as navigationbar]))

(defui SignedInRootView
  static om/Ident
  (ident [this {:keys [id]}]
         [:root-view/by-id id])

  static om/IQuery
  (query [this]
         (let [navbarSubquery (om/get-query navigationbar/Navbar)]
           `[:navigationBars ~navbarSubquery]))
  Object
  (render [this]
          (let [{:keys [navigationBars]} (om/props this)
                rootViewStyle #js {:className "uk-container uk-container-center uk-margin-top"}]
            (dom/div
             rootViewStyle
             (map navigationbar/navbar navigationBars)))))

(def signedInRootView (om/factory SignedInRootView))
