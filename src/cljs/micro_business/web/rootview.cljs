(ns micro-business.web.rootview
  (:require
   [goog.dom :as gdom]
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.web.state :as state]
   [micro-business.web.reader :as reader]
   [micro-business.web.signedinrootview :as signedinrootview]
   [micro-business.web.signedoutrootview :as signedoutrootview]))

(enable-console-print!)

(def getRootViewStyle #js {:className "uk-container uk-container-center uk-margin-top"})

(defui RootView
  static om/IQuery
  (query [this]
         (let [signedInSubquery (om/get-query signedinrootview/SignedInRootView)
               signedOutSubquery (om/get-query signedoutrootview/SignedOutRootView)]
         `[:current-state :root-view {~signedInSubquery ~signedOutSubquery}]))

  Object
  (render [this]
          (let [{:keys [current-state root-view]} (om/props this)]
            (dom/div getRootViewStyle
                     (case current-state
                       :signedIn (signedinrootview/signedInRootView (root-view current-state))
                       :signedOut (signedoutrootview/signedOutRootView (root-view current-state)))))))

(defn- rootViewReconciler [current-state]
  (om/reconciler
   {:state (assoc state/applicationGlobalState :current-state current-state)
    :parser (om/parser {:read reader/read})}))

(defn ^:export renderRootViewInSignedInState [elementName]
  (om/add-root! (rootViewReconciler :signedIn)
                RootView (gdom/getElement elementName)))

(defn ^:export renderRootViewInSignedOutState [elementName]
  (om/add-root! (rootViewReconciler :signedOut)
                RootView (gdom/getElement elementName)))

(renderRootViewInSignedOutState "rootView")
