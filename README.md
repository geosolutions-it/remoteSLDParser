Simple style parsing example, picks a list of styles from a remote location, using a GetStyles request,
parses it via GeoTools, and dumps on the console a few facts about them.

Sample output:

````
--- Found style wind-wb-arrows-lod ---
--- Found style wind-wb-arrows-lod ---
Style has 1 feature type style
  FeatureTypeStyle 1
    Filter: [ lod = 0 ]
    Scales: 2.5E7/4.0E8
      PointSymbolizerImpl
    Filter: [ in([lod], [0], [1]) = true ]
    Scales: 2.0E7/2.5E7
      PointSymbolizerImpl
    Filter: [ in([lod], [0], [1]) = true ]
    Scales: 1.0E7/2.0E7
      PointSymbolizerImpl
    Filter: [ in([lod], [0], [1]) = true ]
    Scales: 3000000.0/1.0E7
      PointSymbolizerImpl
    Filter: [ in([lod], [0], [1], [2], [3]) = true ]
    Scales: 0.0/3000000.0
      PointSymbolizerImpl


--- Found style wind-arrows-lod-text ---
Style has 1 feature type style
  FeatureTypeStyle 1
    Filter: [ lod = 0 ]
    Scales: 2.5E7/Infinity
      PointSymbolizerImpl
      TextSymbolizerImpl
    Filter: [[ lod = 1 ] OR [ lod = 0 ]]
    Scales: 5000000.0/2.5E7
      PointSymbolizerImpl
      TextSymbolizerImpl
    Filter: [[ lod = 1 ] OR [ lod = 0 ] OR [ lod = 2 ]]
    Scales: 1000000.0/5000000.0
      PointSymbolizerImpl
      TextSymbolizerImpl
    Filter: Filter.INCLUDE
    Scales: 0.0/1000000.0
      PointSymbolizerImpl
      TextSymbolizerImpl


--- Found style wind-arrows-lod ---
Style has 1 feature type style
  FeatureTypeStyle 1
    Filter: [ lod = 0 ]
    Scales: 2.5E7/4.0E8
      PointSymbolizerImpl
    Filter: [[ lod = 1 ] OR [ lod = 0 ]]
    Scales: 5000000.0/2.5E7
      PointSymbolizerImpl
    Filter: [[ lod = 1 ] OR [ lod = 0 ] OR [ lod = 2 ]]
    Scales: 1000000.0/5000000.0
      PointSymbolizerImpl
    Filter: Filter.INCLUDE
    Scales: 0.0/1000000.0
      PointSymbolizerImpl
````