(ns micro-business.web.reader
  (:require
   [om.next :as om :refer-macros [defui]]))

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

(defmethod read :navigationBars
  [{:keys [state] :as env} key params]
  (let [st @state
        current-state (st :current-state)
        root-view (st :root-view)
        navigationBars (get-in root-view [current-state :navigationBars])]
    {:value navigationBars}))
