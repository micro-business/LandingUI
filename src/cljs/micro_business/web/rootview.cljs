(ns micro-business.web.rootview
  (:require
   [goog.dom :as gdom]
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.web.state :as state]
   [micro-business.web.reader :as reader]
   [micro-business.web.mutate :as mutate]
   [micro-business.web.signedin.rootview :as signedinrootview]
   [micro-business.web.signedout.rootview :as signedoutrootview]))

(enable-console-print!)

(defui RootView
  static om/IQuery
  (query [this]
         (let [signedInSubquery (om/get-query signedinrootview/SignedInRootView)
               signedOutSubquery (om/get-query signedoutrootview/SignedOutRootView)]
           `[:current-state :root-view {:signedIn ~signedInSubquery :signedOut ~signedOutSubquery}]))

  Object
  (render [this]
          (let [{:keys [current-state root-view]} (om/props this)]
            (case current-state
              :signedIn (signedinrootview/signedInRootView (root-view current-state))
              :signedOut (signedoutrootview/signedOutRootView (root-view current-state))
              (signedoutrootview/signedOutRootView (root-view :signedOut))))))

(def rootViewReconciler
  (om/reconciler
   {:state state/state
    :parser (om/parser {:read reader/read :mutate mutate/mutate})}))

(defn ^:export renderRootView [elementName]
  (om/add-root! rootViewReconciler
                RootView (gdom/getElement elementName)))

(renderRootView "rootView")
