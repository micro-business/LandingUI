(ns micro-business.web.landingpage.state)

(def ^:private navigationBar {:brand "Micro Business"
                              :rightToLeftAlignment false})

(def ^:private signedInNavigationItems {:navigationItems
                                        [{:id "signout" :caption "Sign out" :onClickedQueryExpression `[('signout/clicked) :root-view]}]})

(def ^:private signedOutNavigationItems {:navigationItems
                                         [{:id "signin" :caption "Sign in" :onClickedQueryExpression `[('signin/clicked) :root-view]}]})

(def state
  {:signedInLandingPage
   {:id :signedInLandingPage
    :navigationBars [(merge {:id "topNavigationBarSignedIn"} navigationBar signedInNavigationItems)]}

   :signedOutLandingPage
   {:id :signedOutLandingPage
    :navigationBars [(merge {:id "topNavigationBarSignedOut"} navigationBar signedOutNavigationItems)]}})
