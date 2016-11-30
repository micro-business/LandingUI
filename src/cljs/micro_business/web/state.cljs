(ns micro-business.web.state
  (:require
   [micro-business.web.landingpage.state :as landingpage]))

(def state
  {:root-view
   landingpage/state})
