(ns micro-business.web.rootview
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(enable-console-print!)

(def applicationGlobalState
  {:app/navigationContext {:brand "Micro Business"}})

(defmulti read om/dispatch)

(defmethod read :app/navigationContext
  [{:keys [state] :as env} key params]
  {:value (@state key)})

(def getNavbarStyle #js {:className "uk-navbar"})
(def getNavbarBrandStyle #js {:className "uk-navbar-brand" :href "#"})

(defn getNavbar [{:keys [brand]}]
  (apply dom/nav getNavbarStyle [(dom/a getNavbarBrandStyle brand)]))

(defui Navbar
  static om/IQuery
  (query [this]
         '[:brand])
  Object
  (render [this]
          (getNavbar {:brand (-> this om/props :brand)})))

(def navbar (om/factory Navbar))

(def getRootViewStyle #js {:className "uk-container uk-container-center uk-margin-top"})

(defui RootView
  static om/IQuery
  (query [this]
         (let [navbarSubquery (om/get-query Navbar)]
           `[{:app/navigationContext ~navbarSubquery}]))
  Object
  (render [this]
          (let [{:keys [app/navigationContext]} (om/props this)]
            (apply dom/div getRootViewStyle [(navbar navigationContext)]))))

(def reconciler
  (om/reconciler
   {:state applicationGlobalState
    :parser (om/parser {:read read})}))

(defn ^:export renderRootView [elementName]
  (om/add-root! reconciler
                RootView (gdom/getElement elementName)))

(renderRootView  "rootView")
