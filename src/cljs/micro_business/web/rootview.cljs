(ns micro-business.web.rootview
  (:require
   [goog.dom :as gdom]
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.web.state :as state]
   [micro-business.web.reader :as reader]
   [micro-business.uicomponents.uikit.navigationbar :as navigationbar]))

(enable-console-print!)

(def getRootViewStyle #js {:className "uk-container uk-container-center uk-margin-top"})

(defui RootView
  static om/IQuery
  (query [this]
         (let [navbarSubquery (om/get-query navigationbar/Navbar)]
           `[{:app/navigationContext ~navbarSubquery}]))
  Object
  (render [this]
          (let [{:keys [app/navigationContext]} (om/props this)]
            (apply dom/div getRootViewStyle [(navigationbar/navbar navigationContext)]))))

(def reconciler
  (om/reconciler
   {:state state/applicationGlobalState
    :parser (om/parser {:read reader/read})}))

(defn ^:export renderRootView [elementName]
  (om/add-root! reconciler
                RootView (gdom/getElement elementName)))

(renderRootView  "rootView")
