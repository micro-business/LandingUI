(ns micro-business.web.reader
  (:require
   [micro-business.web.landingpage.reader :as landingpagereader]
   [om.next :as om]))

(defmulti read om/dispatch)

(defmethod read :current-state
  [{:keys [state] :as env} key params]
  (let [st @state
        current-state (st key)]
    {:value current-state}))

(defmethod read :landing-pages
  [{:keys [state] :as env} key params]
  {:value (landingpagereader/getLandingPages @state)})
