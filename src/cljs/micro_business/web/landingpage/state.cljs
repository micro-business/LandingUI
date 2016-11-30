(ns micro-business.web.landingpage.state)

(def ^:private navigationBar {:id "topNavigationBar"
                              :brand "Micro Business"
                              :rightToLeftAlignment false})

(def ^:private signedInNavigationItems {:navigationItems
                                        [{:id "signout" :caption "Sign out" :onClickedQueryExpression `[('signout/clicked) :root-view]}]})

(def ^:private signedOutNavigationItems {:navigationItems
                                         [{:id "signin" :caption "Sign in" :onClickedQueryExpression `[('signin/clicked) :root-view]}]})

(def state
  {:signedInLandingPage
   {:id :signedInLandingPage
    :navigationBars [(merge navigationBar signedInNavigationItems)]}

   :signedOutLandingPage
   {:id :signedOutLandingPage
    :navigationBars [(merge navigationBar signedOutNavigationItems)]}})
