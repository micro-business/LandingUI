(ns micro-business.web.landingpage.reader
  (:require
   [micro-business.uicomponents.uikit.navbar.reader :as navbarreader]))

(defn getLandingPages [state]
  (let [updatedNavBars (navbarreader/getNavigationBars state)
        landingPages (map #(last %) (state :landing-page/by-id))
        updatedLandingPages (map (fn [landingPage]
                                   (let [navigationBarIDs (map #(last %) (landingPage :navigationBars))
                                         navigationBarsInDetail (map (fn [navigationBarID]
                                                                       (first (filter #(= navigationBarID (:id %)) updatedNavBars)))
                                                                     navigationBarIDs)
                                         updatedLandingPage (assoc-in landingPage [:navigationBars] navigationBarsInDetail)]
                                     updatedLandingPage))
                                 landingPages)]
    updatedLandingPages))

