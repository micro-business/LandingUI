(ns micro-business.web.mutate
  (:require
   [om.next :as om]))

(defmulti mutate om/dispatch)

(defmethod mutate 'signin/clicked
  [{:keys [state]} x {:keys [name]}]
  {:action
   (fn [] (swap! state assoc-in [:current-state] :signedIn))})

(defmethod mutate 'signout/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (swap! state assoc-in [:current-state] :signedOut))})

