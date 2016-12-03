(ns micro-business.web.landingpage.reader
  (:require
   [micro-business.uicomponents.uikit.navbar.reader :as navbarreader]))

(defn getLandingPages [state landingPagesKey]
  (let [landingPageIDs (map #(last %) (state landingPagesKey))
        landingPages (map #(get-in state [:landing-page/by-id %]) landingPageIDs)
        navItems (state :navItem/by-id)
        navBars (state :navBar/by-id)
        updatedNavBars (map (fn [navBar]
                              (let [detailPart (last navBar)
                                    navItemDetails (map #(navItems (last %)) (detailPart :navigationItems))
                                    newNavBar (assoc-in detailPart [:navigationItems] (into [] navItemDetails))]
                                newNavBar)) navBars)
        updatedLandingPages (map (fn [landingPage]
                                   (let [navigationBarIDs (map #(last %) (landingPage :navigationBars))
                                         navigationBarsInDetail (map (fn [navigationBarID]
                                                                       (first (filter #(= navigationBarID (:id %)) updatedNavBars)))
                                                                     navigationBarIDs)
                                         updatedLandingPage (assoc-in landingPage [:navigationBars] navigationBarsInDetail)]
                                     updatedLandingPage))
                                 landingPages)]
    updatedLandingPages))

