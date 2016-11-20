(ns micro-business.web.reader
  (:require
   [om.next :as om :refer-macros [defui]]))

(defmulti read om/dispatch)

(defmethod read :app/navigationContext
  [{:keys [state] :as env} key params]
  {:value (@state key)})
