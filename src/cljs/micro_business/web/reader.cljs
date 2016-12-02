(ns micro-business.web.reader
  (:require
   [om.next :as om]))

(defmulti read om/dispatch)

(defmethod read :current-state
  [{:keys [state] :as env} key params]
  (let [st @state
        current-state (st key)]
    {:value current-state}))

(defmethod read :root-view
  [{:keys [state] :as env} key params]
  (let [st @state
        root-view (st key)]
    {:value root-view}))

(defmethod read :signedInLandingPage
  [{:keys [state] :as env} key params]
  (let [st @state
        root-view (st :root-view)
        navigationBars (get-in root-view [key])]
    {:value navigationBars}))

(defmethod read :signedOutLandingPage
  [{:keys [state] :as env} key params]
  (let [st @state
        root-view (st :root-view)
        navigationBars (get-in root-view [key])]
    {:value navigationBars}))
