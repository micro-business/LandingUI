(ns micro-business.web.rootview
  (:require
   [goog.dom :as gdom]
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.web.state :as state]
   [micro-business.web.reader :as reader]
   [micro-business.web.mutate :as mutate]
   [micro-business.web.landingpage.rootview :as landingpagerootview]))

(enable-console-print!)

(defui RootView
  static om/IQuery
  (query [this]
         (let [landingPageSubQuery (om/get-query landingpagerootview/LandingPageRootView)]
           `[:current-state {:landing-pages ~landingPageSubQuery}]))

  Object
  (render [this]
          (let [{:keys [current-state landing-pages]} (om/props this)]
            (case current-state
              :landingPage/signedIn (landingpagerootview/landingPageRootView (first (filter #(= (% :id) :landingPage/signedIn) landing-pages)))
              :landingPage/signedOut (landingpagerootview/landingPageRootView (first (filter #(= (% :id) :landingPage/signedOut) landing-pages)))
              (landingpagerootview/landingPageRootView (first (filter #(= (% :id) :landingPage/signedOut) landing-pages)))))))

(def rootViewReconciler
  (om/reconciler
   {:state state/state
    :parser (om/parser {:read reader/read :mutate mutate/mutate})}))

(defn ^:export renderRootView [elementName]
  (om/add-root! rootViewReconciler
                RootView (gdom/getElement elementName)))

(renderRootView "rootView")
