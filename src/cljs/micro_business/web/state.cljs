(ns micro-business.web.state
  (:require
   [micro-business.web.signedin.state :as signedin]
   [micro-business.web.signedout.state :as signedout]))

(def state
  {:root-view
   {:signedOut signedout/state
    :signedIn signedin/state}})
