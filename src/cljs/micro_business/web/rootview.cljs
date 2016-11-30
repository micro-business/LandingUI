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
         (let [landingPageSubquery (om/get-query landingpagerootview/LandingPageRootView)]
           `[:current-state :root-view {:signedInLandingPage ~landingPageSubquery :signedOutLandingPage ~landingPageSubquery}]))

  Object
  (render [this]
          (let [{:keys [current-state root-view]} (om/props this)]
            (case current-state
              :signedInLandingPage (landingpagerootview/landingPageRootView (root-view current-state))
              :signedOutLandingPage (landingpagerootview/landingPageRootView (root-view current-state))
              (landingpagerootview/landingPageRootView (root-view :signedOutLandingPage))))))

(def rootViewReconciler
  (om/reconciler
   {:state state/state
    :parser (om/parser {:read reader/read :mutate mutate/mutate})}))

(defn ^:export renderRootView [elementName]
  (om/add-root! rootViewReconciler
                RootView (gdom/getElement elementName)))

(renderRootView "rootView")
